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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.oliveryasuna.vaadin.logrocket.exception.SerializationException;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

@JsonSerialize(using = Serializer.class)
public class CaptureOptions implements Serializable {

  // Constructors
  //--------------------------------------------------

  public CaptureOptions() {
    super();
  }

  // Fields
  //--------------------------------------------------

  @JsonProperty("tags")
  private Map<String, Object> tags;

  @JsonProperty("extra")
  private Map<String, Object> extra;

  // Getters/setters
  //--------------------------------------------------

  public Map<String, Object> getTags() {
    return tags;
  }

  public void setTags(final Map<String, Object> tags) {
    this.tags = tags;
  }

  public Map<String, Object> getExtra() {
    return extra;
  }

  public void setExtra(final Map<String, Object> extra) {
    this.extra = extra;
  }

}

// Private classes
//--------------------------------------------------

class Serializer extends StdSerializer<CaptureOptions> {

  // Constructors
  //--------------------------------------------------

  public Serializer() {
    super(CaptureOptions.class);
  }

  @Override
  public void serialize(final CaptureOptions value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();

    if(value.getTags() != null) writeMapField("tags", value.getTags(), gen);
    if(value.getExtra() != null) writeMapField("extra", value.getExtra(), gen);

    gen.writeEndObject();
  }

  private void writeMapField(final String key, final Map<String, Object> map, final JsonGenerator gen) throws IOException {
    gen.writeObjectFieldStart(key);
    writeMap(map, gen);
    gen.writeEndObject();
  }

  private void writeMap(final Map<String, Object> map, final JsonGenerator gen) throws IOException {
    for(final Map.Entry<String, Object> entry : map.entrySet()) {
      final String key = entry.getKey();
      final Object val = entry.getValue();

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

}
