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

package com.oliveryasuna.vaadin.logrocket.config;

import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.vaadin.logrocket.util.JacksonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookupFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Helper methods for loading configuration files.
 *
 * @author Oliver Yasuna
 * @since 1.0.0
 */
public final class AddonConfigurationLoader {

  // Static fields
  //--------------------------------------------------

  private static final String CONFIGURATION_FILENAME = "vaadin-logrocket.properties";

  private static final StringSubstitutor ENVIRONMENT_VARIABLE_SUBSTITUTOR
      = new StringSubstitutor(StringLookupFactory.INSTANCE.environmentVariableStringLookup());

  // Static methods
  //--------------------------------------------------

  public static AddonConfiguration load() throws IOException {
    try(final InputStream is = AddonConfigurationLoader.class.getResourceAsStream("/" + CONFIGURATION_FILENAME)) {
      final String raw = IOUtils.toString(is, StandardCharsets.UTF_8);
      final String resolved = ENVIRONMENT_VARIABLE_SUBSTITUTOR.replace(raw);

      return JacksonUtils.PROPERTIES_MAPPER.readValue(resolved, AddonConfiguration.class);
    }
  }

  // Constructors
  //--------------------------------------------------

  private AddonConfigurationLoader() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
