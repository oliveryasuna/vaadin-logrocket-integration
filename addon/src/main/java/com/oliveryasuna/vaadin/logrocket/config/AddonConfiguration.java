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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * Addon configuration.
 *
 * @author Oliver Yasuna
 */
public class AddonConfiguration implements Serializable {

  // Static fields
  //--------------------------------------------------

  private static final AddonConfiguration INSTANCE = new AddonConfiguration(true, new LogRocketConfiguration(System.getenv("LOGROCKET_APP_ID")));

  private static final ReentrantLock INSTANCE_LOCK = new ReentrantLock();

  // Static methods
  //--------------------------------------------------

  public static AddonConfiguration getInstance() {
    INSTANCE_LOCK.lock();

    try {
      return INSTANCE;
    } finally {
      INSTANCE_LOCK.unlock();
    }
  }

  public static void updateInstance(final Consumer<AddonConfiguration> updateFunction) {
    INSTANCE_LOCK.lock();

    updateFunction.accept(INSTANCE);

    INSTANCE_LOCK.unlock();
  }

  // Constructors
  //--------------------------------------------------

  public AddonConfiguration() {
    super();
  }

  protected AddonConfiguration(final boolean autoInit, final LogRocketConfiguration logRocket) {
    this();

    setAutoInit(autoInit);
    setLogRocket(logRocket);
  }

  // Fields
  //--------------------------------------------------

  @JsonProperty(value = "autoInit")
  private boolean autoInit;

  @JsonProperty(value = "logrocket", required = true)
  private LogRocketConfiguration logRocket;

  // Getters/setters
  //--------------------------------------------------

  public boolean isAutoInit() {
    return autoInit;
  }

  public void setAutoInit(final boolean autoInit) {
    this.autoInit = autoInit;
  }

  public LogRocketConfiguration getLogRocket() {
    return logRocket;
  }

  public void setLogRocket(final LogRocketConfiguration logRocket) {
    this.logRocket = logRocket;
  }

}
