/*
 * Copyright 2023 Oliver Yasuna
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

package com.oliveryasuna.vaadin.logrocket.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.unbrokendome.jackson.beanvalidation.JsonValidated;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * LogRocket JavaScript API's {@code IOptions}.
 *
 * @author Oliver Yasuna
 */
@JsonValidated
public class Options implements Serializable {

  // Constructors
  //--------------------------------------------------

  public Options() {
    super();
  }

  // Fields
  //--------------------------------------------------

  @JsonProperty("release")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String release;

  @JsonProperty("console")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private Console console;

  @JsonProperty("dom")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private Dom dom;

  @JsonProperty("shouldCaptureIP")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean shouldCaptureIP;

  @JsonProperty("rootHostname")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String rootHostname;

  @JsonProperty("ingestServer")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String ingestServer;

  @JsonProperty("sdkServer")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String sdkServer;

  @JsonProperty("uploadTimeInterval")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer uploadTimeInterval;

  @JsonProperty("shouldDebugLog")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean shouldDebugLog;

  @JsonProperty("mergeIframes")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean mergeIframes;

  @JsonProperty("childDomains")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<String> childDomains;

  @JsonProperty("parentDomain")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String parentDomain;

  @JsonProperty("shouldAugmentNPS")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean shouldAugmentNPS;

  @JsonProperty("shouldParseXHRBlob")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean shouldParseXHRBlob;

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

  public Dom getDom() {
    return dom;
  }

  public void setDom(final Dom dom) {
    this.dom = dom;
  }

  public Boolean getShouldCaptureIP() {
    return shouldCaptureIP;
  }

  public void setShouldCaptureIP(final Boolean shouldCaptureIP) {
    this.shouldCaptureIP = shouldCaptureIP;
  }

  public String getRootHostname() {
    return rootHostname;
  }

  public void setRootHostname(final String rootHostname) {
    this.rootHostname = rootHostname;
  }

  public String getIngestServer() {
    return ingestServer;
  }

  public void setIngestServer(final String ingestServer) {
    this.ingestServer = ingestServer;
  }

  public String getSdkServer() {
    return sdkServer;
  }

  public void setSdkServer(final String sdkServer) {
    this.sdkServer = sdkServer;
  }

  public Integer getUploadTimeInterval() {
    return uploadTimeInterval;
  }

  public void setUploadTimeInterval(final Integer uploadTimeInterval) {
    this.uploadTimeInterval = uploadTimeInterval;
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

  public List<String> getChildDomains() {
    return childDomains;
  }

  public void setChildDomains(final List<String> childDomains) {
    this.childDomains = childDomains;
  }

  public String getParentDomain() {
    return parentDomain;
  }

  public void setParentDomain(final String parentDomain) {
    this.parentDomain = parentDomain;
  }

  public Boolean getShouldAugmentNPS() {
    return shouldAugmentNPS;
  }

  public void setShouldAugmentNPS(final Boolean shouldAugmentNPS) {
    this.shouldAugmentNPS = shouldAugmentNPS;
  }

  public Boolean getShouldParseXHRBlob() {
    return shouldParseXHRBlob;
  }

  public void setShouldParseXHRBlob(final Boolean shouldParseXHRBlob) {
    this.shouldParseXHRBlob = shouldParseXHRBlob;
  }

  // Nested
  //--------------------------------------------------

  @JsonValidated
  public static class Console implements Serializable {

    // Constructors
    //--------------------------------------------------

    public Console() {
      super();
    }

    // Fields
    //--------------------------------------------------

    @JsonProperty("isEnabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Valid
    private Object isEnabled;

    @JsonProperty("shouldAggregateConsoleErrors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean shouldAggregateConsoleErrors;

    // Methods
    //--------------------------------------------------

    public void setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
    }

    public void setIsEnabled(final IsEnabled isEnabled) {
      this.isEnabled = isEnabled;
    }

    // Getters/setters
    //--------------------------------------------------

    public Object getIsEnabled() {
      return isEnabled;
    }

    protected void setIsEnabled(final Object isEnabled) {
      this.isEnabled = isEnabled;
    }

    public Boolean getShouldAggregateConsoleErrors() {
      return shouldAggregateConsoleErrors;
    }

    public void setShouldAggregateConsoleErrors(final Boolean shouldAggregateConsoleErrors) {
      this.shouldAggregateConsoleErrors = shouldAggregateConsoleErrors;
    }

    // Nested
    //--------------------------------------------------

    @JsonValidated
    public static class IsEnabled implements Serializable {

      // Constructors
      //--------------------------------------------------

      public IsEnabled() {
        super();
      }

      // Fields
      //--------------------------------------------------

      @JsonProperty("log")
      @JsonInclude(JsonInclude.Include.NON_NULL)
      private Boolean log;

      @JsonProperty("info")
      @JsonInclude(JsonInclude.Include.NON_NULL)
      private Boolean info;

      @JsonProperty("debug")
      @JsonInclude(JsonInclude.Include.NON_NULL)
      private Boolean debug;

      @JsonProperty("warn")
      @JsonInclude(JsonInclude.Include.NON_NULL)
      private Boolean warn;

      @JsonProperty("error")
      @JsonInclude(JsonInclude.Include.NON_NULL)
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

  @JsonValidated
  public static class Dom implements Serializable {

    // Constructors
    //--------------------------------------------------

    public Dom() {
      super();
    }

    // Fields
    //--------------------------------------------------

    @JsonProperty("isEnabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isEnabled;

    @JsonProperty("baseHref")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String baseHref;

    @JsonProperty("textSanitizer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object textSanitizer;

    @JsonProperty("inputSanitizer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object inputSanitizer;

    @JsonProperty("privateAttributeBlocklist")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> privateAttributeBlocklist;

    // Methods
    //--------------------------------------------------

    public void setTextSanitizer(final Boolean textSanitizer) {
      this.textSanitizer = textSanitizer;
    }

    public void setTextSanitizer(final String textSanitizer) {
      this.textSanitizer = textSanitizer;
    }

    public void setInputSanitizer(final Boolean inputSanitizer) {
      this.inputSanitizer = inputSanitizer;
    }

    public void setInputSanitizer(final String inputSanitizer) {
      this.inputSanitizer = inputSanitizer;
    }

    // Getters/setters
    //--------------------------------------------------

    public Boolean getEnabled() {
      return isEnabled;
    }

    public void setEnabled(final Boolean enabled) {
      isEnabled = enabled;
    }

    public String getBaseHref() {
      return baseHref;
    }

    public void setBaseHref(final String baseHref) {
      this.baseHref = baseHref;
    }

    public Object getTextSanitizer() {
      return textSanitizer;
    }

    public Object getInputSanitizer() {
      return inputSanitizer;
    }

    public List<String> getPrivateAttributeBlocklist() {
      return privateAttributeBlocklist;
    }

    public void setPrivateAttributeBlocklist(final List<String> privateAttributeBlocklist) {
      this.privateAttributeBlocklist = privateAttributeBlocklist;
    }

  }

}
