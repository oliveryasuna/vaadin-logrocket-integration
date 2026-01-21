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

package com.oliveryasuna.vaadin.logrocket.demo.ui.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.oliveryasuna.vaadin.logrocket.LogRocket;
import com.oliveryasuna.vaadin.logrocket.util.SerializationUtils;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/")
public final class HomeView extends Composite<VerticalLayout> {

  @Override
  protected VerticalLayout initContent() {
    final VerticalLayout content = new VerticalLayout();
    content.add(new Span("HOME"));
    content.add(new Button("LogRocket.identify", event -> {
      final ObjectNode traits = SerializationUtils.JSON_MAPPER.createObjectNode();
      traits.put("test", "test");

      LogRocket.identify("Oliver", traits);
    }));
    content.add(new Button("LogRocket.captureMessage", event -> {
      final ObjectNode options = SerializationUtils.JSON_MAPPER.createObjectNode();
      final ObjectNode tags = SerializationUtils.JSON_MAPPER.createObjectNode();
      tags.put("test", "test");
      options.set("tags", tags);

      LogRocket.captureMessage("Test message", options);
    }));
    content.add(new Button("Throw client-side error", event -> UI.getCurrent().getPage().executeJs("throw new Error('Test error')")));
    content.add(new Button("Log client-side error", event -> UI.getCurrent().getPage().executeJs("console.error('Test error')")));

    return content;
  }

}
