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

package com.oliveryasuna.vaadin.logrocket.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.vaadin.logrocket.exception.SerializationException;
import elemental.json.Json;
import elemental.json.JsonObject;
import org.unbrokendome.jackson.beanvalidation.BeanValidationModule;

import javax.validation.Validation;

/**
 * Serialization utilities.
 *
 * @author Oliver Yasuna
 */
public final class SerializationUtils {

  // Static fields
  //--------------------------------------------------

  public static final ObjectMapper JSON_MAPPER = new JsonMapper()
      .registerModule(new BeanValidationModule(Validation.byDefaultProvider().configure().buildValidatorFactory()));

  public static final JavaPropsMapper PROPERTIES_MAPPER = new JavaPropsMapper();

  // Static methods
  //--------------------------------------------------

  public static JsonObject toElementalObject(final Object value) {
    final String rawJson;
    try {
      rawJson = SerializationUtils.JSON_MAPPER.writeValueAsString(value);
    } catch(final JsonProcessingException e) {
      throw new SerializationException(e);
    }

    return Json.parse(rawJson);
  }

  // Constructors
  //--------------------------------------------------

  private SerializationUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
