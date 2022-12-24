# vaadin-logrocket-integration

[![](https://img.shields.io/vaadin-directory/version/logrocket-integration)](https://vaadin.com/directory/component/logrocket-integration)
[![](https://img.shields.io/vaadin-directory/star/logrocket-integration)](https://vaadin.com/directory/component/logrocket-integration)

Integrates LogRocket with your Vaadin application.

## Usage

1. **Include the dependency in your project.**

```xml
<dependency>
  <groupId>org.vaadin.addons.oliveryasuna</groupId>
  <artifactId>vaadin-logrocket-integration</artifactId>
  <version>1.0.0</version>
</dependency>
```

2. **Set your LogRocket app ID.**

Set the `LOGROCKET_APP_ID` environment variable to your LogRocket app ID.

_Alternatively, you can set it directly in the configuration.
Read more [here](#configuration)._

3. **Identify your users.**

Use one of the `identify` methods in the class `LogRocket` to identify your users.

For example:
```java
public void onAuthenticate(final User user) {
  LogRocket.identify(user.getId(), user.getName(), user.getEmail());
}
```

### Configuration

Create a file name `vaadin-logrocket.properties` in `src/main/resources`.

| Property          | Description                                     | Default               |
|-------------------|-------------------------------------------------|-----------------------|
| `autoInit`        | Automatically initialize LogRocket for new UIs. | `true`                |
| `logrocket.appId` | LogRocket app ID.                               | `${LOGROCKET_APP_ID}` |

## License

This repository and its contents are licensed by [BSD 3-Clause](LICENSE.txt).

In other words, feel free to use this in your projects, but please give credits to its author(s).

## Sponsoring

If you like my work and want to support it, please consider [sponsoring](https://github.com/sponsors/oliveryasuna) me. It's how I make the time to code great things!
