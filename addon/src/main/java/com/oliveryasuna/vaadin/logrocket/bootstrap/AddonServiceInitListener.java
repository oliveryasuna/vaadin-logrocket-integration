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

import com.oliveryasuna.vaadin.logrocket.config.AddonConfiguration;
import com.oliveryasuna.vaadin.logrocket.config.AddonConfigurationLoader;
import com.oliveryasuna.vaadin.logrocket.exception.ConfigurationLoadException;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import java.util.ServiceLoader;

/**
 * Vaadin service init listener for the addon.
 *
 * @author Oliver Yasuna
 */
public class AddonServiceInitListener implements VaadinServiceInitListener {

  // Constructors
  //--------------------------------------------------

  public AddonServiceInitListener() {
    super();
  }

  // Methods
  //--------------------------------------------------

  protected void initConfig() {
    final ServiceLoader<AddonConfigurationLoader> serviceLoader = ServiceLoader.load(AddonConfigurationLoader.class);

    for(final AddonConfigurationLoader configurationLoader : serviceLoader) {
      try {
        configurationLoader.load();
      } catch(final Exception e) {
        throw new ConfigurationLoadException(e);
      }
    }
  }

  @Override
  public final void serviceInit(final ServiceInitEvent event) {
    initConfig();

    AddonConfiguration.getInstance(addonConfiguration -> {
      if(!addonConfiguration.isAutoInit()) return;

      final LogRocketBootstrapper logRocketBootstrapper = new LogRocketBootstrapper();

      event.addIndexHtmlRequestListener(logRocketBootstrapper);
      event.getSource().addUIInitListener(logRocketBootstrapper);
    });
  }

}
