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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.BooleanUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Counterpart to the LogRocket JavaScript API's {@code IOptions}.
 *
 * @author Oliver Yasuna
 * @since 1.1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitOptions implements Serializable {

  // Constructors
  //--------------------------------------------------

  public InitOptions() {
    super();
  }

  // Fields
  //--------------------------------------------------

  @JsonProperty("release")
  private String release;

  @JsonProperty("console")
  private Console console;

  @JsonProperty("network")
  private Network network;

  @JsonProperty("dom")
  private Dom dom;

  @JsonProperty("shouldCaptureIP")
  private Boolean shouldCaptureIp;

  @JsonProperty("rootHostname")
  private String rootHostname;

  @JsonProperty("shouldDebugLog")
  private Boolean shouldDebugLog;

  @JsonProperty("mergeIframes")
  private Boolean mergeIframes;

  // Getters/setters
  //--------------------------------------------------

  public String getRelease() {
    return release;
  }

  public void setRelease(final String release) {
    this.release = release;
  }

  public Console getConsole() {
    return console;
  }

  public void setConsole(final Console console) {
    this.console = console;
  }

  public Network getNetwork() {
    return network;
  }

  public void setNetwork(final Network network) {
    this.network = network;
  }

  public Dom getDom() {
    return dom;
  }

  public void setDom(final Dom dom) {
    this.dom = dom;
  }

  public Boolean getShouldCaptureIp() {
    return shouldCaptureIp;
  }

  public void setShouldCaptureIp(final Boolean shouldCaptureIp) {
    this.shouldCaptureIp = shouldCaptureIp;
  }

  public String getRootHostname() {
    return rootHostname;
  }

  public void setRootHostname(final String rootHostname) {
    this.rootHostname = rootHostname;
  }

  public Boolean getShouldDebugLog() {
    return shouldDebugLog;
  }

  public void setShouldDebugLog(final Boolean shouldDebugLog) {
    this.shouldDebugLog = shouldDebugLog;
  }

  public Boolean getMergeIframes() {
    return mergeIframes;
  }

  public void setMergeIframes(final Boolean mergeIframes) {
    this.mergeIframes = mergeIframes;
  }

  // Nested
  //--------------------------------------------------

  @JsonSerialize(using = InitOptionsConsoleSerializer.class)
  public static class Console implements Serializable {

    // Constructors
    //--------------------------------------------------

    public Console() {
      super();
    }

    // Fields
    //--------------------------------------------------

    @JsonProperty("isEnabled")
    private Boolean isEnabled;

    @JsonProperty("isEnabled")
    private IsEnabled isEnabledObject;

    @JsonProperty("shouldAggregateConsoleErrors")
    private Boolean shouldAggregateConsoleErrors;

    // Getters/setters
    //--------------------------------------------------

    public Boolean getIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public IsEnabled getIsEnabledObject() {
      return isEnabledObject;
    }

    public void setIsEnabledObject(final IsEnabled isEnabledObject) {
      this.isEnabledObject = isEnabledObject;
    }

    public Boolean getShouldAggregateConsoleErrors() {
      return shouldAggregateConsoleErrors;
    }

    public void setShouldAggregateConsoleErrors(final Boolean shouldAggregateConsoleErrors) {
      this.shouldAggregateConsoleErrors = shouldAggregateConsoleErrors;
    }

    // Nested
    //--------------------------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class IsEnabled implements Serializable {

      // Constructors
      //--------------------------------------------------

      public IsEnabled() {
        super();
      }

      // Fields
      //--------------------------------------------------

      @JsonProperty("log")
      private Boolean log;

      @JsonProperty("info")
      private Boolean info;

      @JsonProperty("debug")
      private Boolean debug;

      @JsonProperty("warn")
      private Boolean warn;

      @JsonProperty("error")
      private Boolean error;

      // Getters/setters
      //--------------------------------------------------

      public Boolean getLog() {
        return log;
      }

      public void setLog(final Boolean log) {
        this.log = log;
      }

      public Boolean getInfo() {
        return info;
      }

      public void setInfo(final Boolean info) {
        this.info = info;
      }

      public Boolean getDebug() {
        return debug;
      }

      public void setDebug(final Boolean debug) {
        this.debug = debug;
      }

      public Boolean getWarn() {
        return warn;
      }

      public void setWarn(final Boolean warn) {
        this.warn = warn;
      }

      public Boolean getError() {
        return error;
      }

      public void setError(final Boolean error) {
        this.error = error;
      }

    }

  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Network implements Serializable {

    // Constructors
    //--------------------------------------------------

    public Network() {
      super();
    }

    // Fields
    //--------------------------------------------------

    @JsonProperty("isEnabled")
    private Boolean isEnabled;

    // Getters/setters
    //--------------------------------------------------

    public Boolean getIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Dom implements Serializable {

    // Constructors
    //--------------------------------------------------

    public Dom() {
      super();
    }

    // Fields
    //--------------------------------------------------

    @JsonProperty("isEnabled")
    private Boolean isEnabled;

    @JsonProperty("inputSanitizer")
    private Boolean inputSanitizer;

    @JsonProperty("textSanitizer")
    private Boolean textSanitizer;

    @JsonProperty("baseHref")
    private String baseHref;

    // Getters/setters
    //--------------------------------------------------

    public Boolean getIsEnabled() {
      return isEnabled;
    }

    public void setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public Boolean getEnabled() {
      return isEnabled;
    }

    public void setEnabled(final Boolean enabled) {
      isEnabled = enabled;
    }

    public Boolean getInputSanitizer() {
      return inputSanitizer;
    }

    public void setInputSanitizer(final Boolean inputSanitizer) {
      this.inputSanitizer = inputSanitizer;
    }

    public Boolean getTextSanitizer() {
      return textSanitizer;
    }

    public void setTextSanitizer(final Boolean textSanitizer) {
      this.textSanitizer = textSanitizer;
    }

    public String getBaseHref() {
      return baseHref;
    }

    public void setBaseHref(final String baseHref) {
      this.baseHref = baseHref;
    }

  }

}

// Private classes
//--------------------------------------------------

final class InitOptionsConsoleSerializer extends StdSerializer<InitOptions.Console> {

  // Constructors
  //--------------------------------------------------

  public InitOptionsConsoleSerializer() {
    super(InitOptions.Console.class);
  }

  // Methods
  //--------------------------------------------------

  @Override
  public final void serialize(final InitOptions.Console value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();

    if(BooleanUtils.isTrue(value.getIsEnabled())) {
      gen.writeBooleanField("isEnabled", value.getIsEnabled());
    } else if(value.getIsEnabledObject() != null) {
      gen.writeObjectField("isEnabled", value.getIsEnabledObject());
    }
    if(value.getShouldAggregateConsoleErrors() != null) {
      gen.writeBooleanField("shouldAggregateConsoleErrors", value.getShouldAggregateConsoleErrors());
    }

    gen.writeEndObject();
  }

}
