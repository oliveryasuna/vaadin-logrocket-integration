/*
 * Copyright 2022 Oliver Yasuna
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without
 *      specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.oliveryasuna.vaadin.logrocket;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.oliveryasuna.vaadin.logrocket.exception.SerializationException;

import java.io.IOException;
import java.util.Map;

@JsonSerialize(using = TrackEventPropertiesSerializer.class)
public class TrackEventProperties {

  // Constructors
  //--------------------------------------------------

  public TrackEventProperties() {
    super();
  }

  // Fields
  //--------------------------------------------------

  private Double revenue;

  private Map<String, Object> properties;

  // Getters/setters
  //--------------------------------------------------

  public Double getRevenue() {
    return revenue;
  }

  public void setRevenue(final Double revenue) {
    this.revenue = revenue;
  }

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(final Map<String, Object> properties) {
    this.properties = properties;
  }

}

// Private classes
//--------------------------------------------------

final class TrackEventPropertiesSerializer extends StdSerializer<TrackEventProperties> {

  // Constructors
  //--------------------------------------------------

  public TrackEventPropertiesSerializer() {
    super(TrackEventProperties.class);
  }

  // Methods
  //--------------------------------------------------

  @Override
  public final void serialize(final TrackEventProperties value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();

    if(value.getRevenue() != null) {
      gen.writeNumberField("revenue", value.getRevenue());
    }
    if(value.getProperties() != null) {
      gen.writeObjectFieldStart("properties");
      for(final Map.Entry<String, Object> properties : value.getProperties().entrySet()) {
        final String key = properties.getKey();
        final Object val = properties.getValue();

        if(val == null) {
          gen.writeNullField(key);
        } else if(val.getClass().isArray()) {
          final Class<?> type = val.getClass().getComponentType();

          gen.writeArrayFieldStart(key);
          if(type == String.class) {
            for(final String s : (String[])val) gen.writeString(s);
          } else if(type == Integer.class) {
            for(final Integer i : (Integer[])val) gen.writeNumber(i);
          } else if(type == Long.class) {
            for(final Long l : (Long[])val) gen.writeNumber(l);
          } else if(type == Double.class) {
            for(final Double d : (Double[])val) gen.writeNumber(d);
          } else if(type == Float.class) {
            for(final Float f : (Float[])val) gen.writeNumber(f);
          } else if(type == Boolean.class) {
            for(final Boolean b : (Boolean[])val) gen.writeBoolean(b);
          } else {
            throw new SerializationException("Unsupported array type: " + type);
          }
          gen.writeEndArray();
        } else {
          if(val instanceof String) {
            gen.writeStringField(key, (String)val);
          } else if(val instanceof Integer) {
            gen.writeNumberField(key, (Integer)val);
          } else if(val instanceof Long) {
            gen.writeNumberField(key, (Long)val);
          } else if(val instanceof Double) {
            gen.writeNumberField(key, (Double)val);
          } else if(val instanceof Float) {
            gen.writeNumberField(key, (Float)val);
          } else if(val instanceof Boolean) {
            gen.writeBooleanField(key, (Boolean)val);
          } else {
            throw new SerializationException("Unsupported type: " + val.getClass());
          }
        }
      }
      gen.writeEndObject();
    }

    gen.writeEndObject();
  }

}
