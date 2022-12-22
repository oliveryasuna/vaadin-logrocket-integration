# vaadin-logrocket-integration

Integrates LogRocket with your Vaadin application.

## Usage

1. Include the dependency in your project.

```xml
<dependency>
  <groupId>org.vaadin.addons.oliveryasuna</groupId>
  <artifactId>vaadin-logrocket-integration</artifactId>
  <version>1.0.0</version>
</dependency>
```

2. Configure the addon.

You can configure the addon with a properties file or environment variables.

Here's an example properties file:
```properties
logrocket.appId = LOGROCKET_ID
```
It goes at `src/main/resources/vaadin-logrocket.properties`.

You can also configure the addon with environment variables:
- `LOGROCKET_APP_ID`

[//]: # (TODO: Finish.)

## License

This code is under the [BSD 3-Clause](LICENSE.txt).

## Sponsoring

If you like my work and want to support it, please consider [sponsoring](https://github.com/sponsors/oliveryasuna) me. It's how I make the time to code great things!
