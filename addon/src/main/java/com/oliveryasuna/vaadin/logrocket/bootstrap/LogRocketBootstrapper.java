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

package com.oliveryasuna.vaadin.logrocket.bootstrap;

import com.oliveryasuna.vaadin.logrocket.LogRocket;
import com.oliveryasuna.vaadin.logrocket.config.AddonConfiguration;
import com.oliveryasuna.vaadin.logrocket.config.LogRocketConfiguration;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.UIInitEvent;
import com.vaadin.flow.server.UIInitListener;
import com.vaadin.flow.server.communication.IndexHtmlRequestListener;
import com.vaadin.flow.server.communication.IndexHtmlResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Handles LogRocket on the client-side.
 *
 * @author Oliver Yasuna
 * @since 1.0.0
 */
public class LogRocketBootstrapper implements IndexHtmlRequestListener, UIInitListener {

  // Constructors
  //--------------------------------------------------

  public LogRocketBootstrapper() {
    super();
  }

  // Methods
  //--------------------------------------------------

  @Override
  public void modifyIndexHtmlResponse(final IndexHtmlResponse response) {
    final Document document = response.getDocument();

    final Element scriptElement = document.createElement("script");
    scriptElement.attr("src", "https://cdn.lr-in-prod.com/LogRocket.min.js");
    scriptElement.attr("crossorigin", "anonymous");

    document.head().appendChild(scriptElement);
  }

  @Override
  public void uiInit(final UIInitEvent event) {
    final UI ui = event.getUI();

    if(AddonConfiguration.getInstance().isAutoInit()) {
      LogRocket.init(ui, LogRocketConfiguration.getInstance().getAppId());
    }
  }

}
