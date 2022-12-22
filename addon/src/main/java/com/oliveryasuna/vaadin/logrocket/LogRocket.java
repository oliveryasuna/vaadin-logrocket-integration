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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.vaadin.logrocket.exception.SerializationException;
import com.oliveryasuna.vaadin.logrocket.util.JacksonUtils;
import com.vaadin.flow.component.UI;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

/**
 * LogRocket utility class.
 *
 * @author Oliver Yasuna
 * @since 1.0.0
 */
public final class LogRocket {

  // Static methods
  //--------------------------------------------------

  public static void init(final UI ui, final String appId) {
    ui.getPage().executeJs("window.LogRocket.init($0)", appId);
  }

  public static void init(final String appId) {
    init(UI.getCurrent(), appId);
  }

  public static void init(final UI ui, final String appId, JsonObject options) {
    ui.getPage().executeJs("window.LogRocket.init($0, $1)", appId, options);
  }

  public static void init(final String appId, JsonObject options) {
    init(UI.getCurrent(), appId, options);
  }

  public static void init(final UI ui, final String appId, final InitOptions options) {
    final String rawJson;
    try {
      rawJson = JacksonUtils.JSON_MAPPER.writeValueAsString(options);
    } catch(final JsonProcessingException e) {
      throw new SerializationException(e);
    }

    init(ui, appId, Json.parse(rawJson));
  }

  public static void init(final String appId, final InitOptions options) {
    init(UI.getCurrent(), appId, options);
  }

  public static void log(final UI ui, final String pattern, final Object... arguments) {
    ui.getPage().executeJs("window.LogRocket.log($0)", MessageFormat.format(pattern, arguments));
  }

  public static void log(final String pattern, final Object... arguments) {
    log(UI.getCurrent(), pattern, arguments);
  }

  public static void info(final UI ui, final String pattern, final Object... arguments) {
    ui.getPage().executeJs("window.LogRocket.info($0)", MessageFormat.format(pattern, arguments));
  }

  public static void info(final String pattern, final Object... arguments) {
    info(UI.getCurrent(), pattern, arguments);
  }

  public static void warn(final UI ui, final String pattern, final Object... arguments) {
    ui.getPage().executeJs("window.LogRocket.warn($0)", MessageFormat.format(pattern, arguments));
  }

  public static void warn(final String pattern, final Object... arguments) {
    warn(UI.getCurrent(), pattern, arguments);
  }

  public static void debug(final UI ui, final String pattern, final Object... arguments) {
    ui.getPage().executeJs("window.LogRocket.debug($0)", MessageFormat.format(pattern, arguments));
  }

  public static void debug(final String pattern, final Object... arguments) {
    debug(UI.getCurrent(), pattern, arguments);
  }

  public static void error(final UI ui, final String pattern, final Object... arguments) {
    ui.getPage().executeJs("window.LogRocket.error($0)", MessageFormat.format(pattern, arguments));
  }

  public static void error(final String pattern, final Object... arguments) {
    error(UI.getCurrent(), pattern, arguments);
  }

  public static CompletableFuture<String> version(final UI ui) {
    return ui.getPage().executeJs("window.LogRocket.version")
        .toCompletableFuture(String.class);
  }

  public static void identify(final UI ui, final String uid, final JsonObject options) {
    ui.getPage().executeJs("window.LogRocket.identify($0, $1)", uid, options);
  }

  public static void identify(final String uid, final JsonObject options) {
    identify(UI.getCurrent(), uid, options);
  }

  public static void identify(final UI ui, final JsonObject options) {
    ui.getPage().executeJs("window.LogRocket.identify($0)", options);
  }

  public static void identify(final JsonObject options) {
    identify(UI.getCurrent(), options);
  }

  public static void identify(final UI ui, final String uid, final String name, final String email) {
    final JsonObject object = Json.createObject();
    object.put("name", name);
    object.put("email", email);

    identify(ui, uid, object);
  }

  public static void identify(final String uid, final String name, final String email) {
    identify(UI.getCurrent(), uid, name, email);
  }

  public static void identify(final UI ui, final String name, final String email) {
    final JsonObject object = Json.createObject();
    object.put("name", name);
    object.put("email", email);

    identify(ui, object);
  }

  public static void identify(final String name, final String email) {
    identify(UI.getCurrent(), name, email);
  }

  // Constructors
  //--------------------------------------------------

  private LogRocket() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
