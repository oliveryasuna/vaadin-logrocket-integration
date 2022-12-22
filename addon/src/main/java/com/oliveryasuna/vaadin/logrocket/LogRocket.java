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
import com.vaadin.flow.component.UI;
import elemental.json.Json;
import elemental.json.JsonObject;

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
    ui.getPage().executeJs("window.LogRocket && window.LogRocket.init($0)", appId);
  }

  public static void init(final String appId) {
    init(UI.getCurrent(), appId);
  }

  public static void identify(final UI ui, final String uid, final JsonObject options) {
    ui.getPage().executeJs("window.LogRocket && window.LogRocket.identify($0, $1)", uid, options);
  }

  public static void identify(final String uid, final JsonObject options) {
    identify(UI.getCurrent(), uid, options);
  }

  public static void identify(final UI ui, final JsonObject options) {
    ui.getPage().executeJs("window.LogRocket && window.LogRocket.identify($0)", options);
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
