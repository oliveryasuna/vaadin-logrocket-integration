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

import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.vaadin.logrocket.type.CaptureOptions;
import com.oliveryasuna.vaadin.logrocket.type.Error;
import com.oliveryasuna.vaadin.logrocket.type.Options;
import com.oliveryasuna.vaadin.logrocket.type.TrackEventProperties;
import com.oliveryasuna.vaadin.logrocket.util.SerializationUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

/**
 * LogRocket utility class.
 *
 * @author Oliver Yasuna
 */
public final class LogRocket {

  // Static methods
  //--------------------------------------------------

  public static PendingJavaScriptResult init(final UI ui, final String appId) {
    return ui.getPage().executeJs("window.LogRocket.init($0)", appId);
  }

  public static PendingJavaScriptResult init(final String appId) {
    return init(UI.getCurrent(), appId);
  }

  public static PendingJavaScriptResult init(final UI ui, final String appId, JsonObject options) {
    return ui.getPage().executeJs("window.LogRocket.init($0, $1)", appId, options);
  }

  public static PendingJavaScriptResult init(final String appId, JsonObject options) {
    return init(UI.getCurrent(), appId, options);
  }

  public static PendingJavaScriptResult init(final UI ui, final String appId, final Options options) {
    return init(ui, appId, SerializationUtils.toElementalObject(options));
  }

  public static PendingJavaScriptResult init(final String appId, final Options options) {
    return init(UI.getCurrent(), appId, options);
  }

  public static PendingJavaScriptResult log(final UI ui, final String pattern, final Object... arguments) {
    return ui.getPage().executeJs("window.LogRocket.log($0)", MessageFormat.format(pattern, arguments));
  }

  public static PendingJavaScriptResult log(final String pattern, final Object... arguments) {
    return log(UI.getCurrent(), pattern, arguments);
  }

  public static PendingJavaScriptResult info(final UI ui, final String pattern, final Object... arguments) {
    return ui.getPage().executeJs("window.LogRocket.info($0)", MessageFormat.format(pattern, arguments));
  }

  public static PendingJavaScriptResult info(final String pattern, final Object... arguments) {
    return info(UI.getCurrent(), pattern, arguments);
  }

  public static PendingJavaScriptResult warn(final UI ui, final String pattern, final Object... arguments) {
    return ui.getPage().executeJs("window.LogRocket.warn($0)", MessageFormat.format(pattern, arguments));
  }

  public static PendingJavaScriptResult warn(final String pattern, final Object... arguments) {
    return warn(UI.getCurrent(), pattern, arguments);
  }

  public static PendingJavaScriptResult debug(final UI ui, final String pattern, final Object... arguments) {
    return ui.getPage().executeJs("window.LogRocket.debug($0)", MessageFormat.format(pattern, arguments));
  }

  public static PendingJavaScriptResult debug(final String pattern, final Object... arguments) {
    return debug(UI.getCurrent(), pattern, arguments);
  }

  public static PendingJavaScriptResult error(final UI ui, final String pattern, final Object... arguments) {
    return ui.getPage().executeJs("window.LogRocket.error($0)", MessageFormat.format(pattern, arguments));
  }

  public static PendingJavaScriptResult error(final String pattern, final Object... arguments) {
    return error(UI.getCurrent(), pattern, arguments);
  }

  public static PendingJavaScriptResult identify(final UI ui, final String uid, final JsonObject options) {
    return ui.getPage().executeJs("window.LogRocket.identify($0, $1)", uid, options);
  }

  public static PendingJavaScriptResult identify(final String uid, final JsonObject options) {
    return identify(UI.getCurrent(), uid, options);
  }

  public static PendingJavaScriptResult identify(final UI ui, final JsonObject options) {
    return ui.getPage().executeJs("window.LogRocket.identify($0)", options);
  }

  public static PendingJavaScriptResult identify(final JsonObject options) {
    return identify(UI.getCurrent(), options);
  }

  public static PendingJavaScriptResult identify(final UI ui, final String uid, final String name, final String email) {
    final JsonObject object = Json.createObject();
    object.put("name", name);
    object.put("email", email);

    return identify(ui, uid, object);
  }

  public static PendingJavaScriptResult identify(final String uid, final String name, final String email) {
    return identify(UI.getCurrent(), uid, name, email);
  }

  public static PendingJavaScriptResult identify(final UI ui, final String name, final String email) {
    final JsonObject object = Json.createObject();
    object.put("name", name);
    object.put("email", email);

    return identify(ui, object);
  }

  public static PendingJavaScriptResult identify(final String name, final String email) {
    return identify(UI.getCurrent(), name, email);
  }

  public static PendingJavaScriptResult track(final UI ui, final String eventName) {
    return ui.getPage().executeJs("window.LogRocket.track($0)", eventName);
  }

  public static PendingJavaScriptResult track(final String eventName) {
    return track(UI.getCurrent(), eventName);
  }

  public static PendingJavaScriptResult track(final UI ui, final String eventName, final JsonObject properties) {
    return ui.getPage().executeJs("window.LogRocket.track($0, $1)", eventName, properties);
  }

  public static PendingJavaScriptResult track(final String eventName, final JsonObject properties) {
    return track(UI.getCurrent(), eventName, properties);
  }

  public static PendingJavaScriptResult track(final UI ui, final String eventName, final TrackEventProperties properties) {
    return track(ui, eventName, SerializationUtils.toElementalObject(properties));
  }

  public static PendingJavaScriptResult track(final String eventName, final TrackEventProperties properties) {
    return track(UI.getCurrent(), eventName, properties);
  }

  public static PendingJavaScriptResult startNewSession(final UI ui) {
    return ui.getPage().executeJs("window.LogRocket.startNewSession()");
  }

  public static PendingJavaScriptResult startNewSession() {
    return startNewSession(UI.getCurrent());
  }

  public static CompletableFuture<String> version(final UI ui) {
    return ui.getPage().executeJs("window.LogRocket.version")
        .toCompletableFuture(String.class);
  }

  public static CompletableFuture<String> version() {
    return version(UI.getCurrent());
  }

  public static CompletableFuture<String> sessionURL(final UI ui) {
    return ui.getPage().executeJs("window.LogRocket.sessionURL")
        .toCompletableFuture(String.class);
  }

  public static CompletableFuture<String> sessionURL() {
    return sessionURL(UI.getCurrent());
  }

  public static PendingJavaScriptResult captureMessage(final UI ui, final String message) {
    return ui.getPage().executeJs("window.LogRocket.captureMessage($0)", message);
  }

  public static PendingJavaScriptResult captureMessage(final String message) {
    return captureMessage(UI.getCurrent(), message);
  }

  public static PendingJavaScriptResult captureMessage(final UI ui, final String message, final JsonObject options) {
    return ui.getPage().executeJs("window.LogRocket.captureMessage($0, $1)", message, options);
  }

  public static PendingJavaScriptResult captureMessage(final String message, final JsonObject options) {
    return captureMessage(UI.getCurrent(), message, options);
  }

  public static PendingJavaScriptResult captureMessage(final UI ui, final String message, final CaptureOptions options) {
    return captureMessage(ui, message, SerializationUtils.toElementalObject(options));
  }

  public static PendingJavaScriptResult captureMessage(final String message, final CaptureOptions options) {
    return captureMessage(UI.getCurrent(), message, options);
  }

  public static PendingJavaScriptResult captureException(final UI ui, final JsonObject exception) {
    return ui.getPage().executeJs("window.LogRocket.captureException($0)", exception);
  }

  public static PendingJavaScriptResult captureException(final JsonObject exception) {
    return captureException(UI.getCurrent(), exception);
  }

  public static PendingJavaScriptResult captureException(final UI ui, final JsonObject exception, final JsonObject options) {
    return ui.getPage().executeJs("window.LogRocket.captureException($0, $1)", exception, options);
  }

  public static PendingJavaScriptResult captureException(final JsonObject exception, final JsonObject options) {
    return captureException(UI.getCurrent(), exception, options);
  }

  public static PendingJavaScriptResult captureException(final UI ui, final JsonObject exception, final CaptureOptions options) {
    return captureException(ui, exception, SerializationUtils.toElementalObject(options));
  }

  public static PendingJavaScriptResult captureException(final JsonObject exception, final CaptureOptions options) {
    return captureException(UI.getCurrent(), exception, options);
  }

  public static PendingJavaScriptResult captureException(final UI ui, final Error exception) {
    return captureException(ui, SerializationUtils.toElementalObject(exception));
  }

  public static PendingJavaScriptResult captureException(final Error exception) {
    return captureException(UI.getCurrent(), exception);
  }

  public static PendingJavaScriptResult captureException(final UI ui, final Error exception, final JsonObject options) {
    return captureException(ui, SerializationUtils.toElementalObject(exception), options);
  }

  public static PendingJavaScriptResult captureException(final Error exception, final JsonObject options) {
    return captureException(UI.getCurrent(), exception, options);
  }

  public static PendingJavaScriptResult captureException(final UI ui, final Error exception, final CaptureOptions options) {
    return captureException(ui, exception, SerializationUtils.toElementalObject(exception));
  }

  public static PendingJavaScriptResult captureException(final Error exception, final CaptureOptions options) {
    return captureException(UI.getCurrent(), exception, options);
  }

  // Constructors
  //--------------------------------------------------

  private LogRocket() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
