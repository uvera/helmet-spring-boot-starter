# Helmet

[![](https://jitpack.io/v/uvera/helmet-spring-boot-starter.svg)](https://jitpack.io/#uvera/helmet-spring-boot-starter)

Helmet secures your spring Webflux or MVC app by setting various HTTP headers.

This is a 1:1 copy of [ Helmet.js ]( https://raw.githubusercontent.com/helmetjs/helmet)

## Quick start

Add `https://jitpack.to` to your build tool maven repositories.

More info at [ helmet jitpack io repository ](https://jitpack.io/#uvera/helmet-spring-boot-starter)

Add `com.github.uvera.helmet-spring-boot-starter` to your dependencies.

### Maven

```xml

<project>
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependecies>
        <dependency>
            <groupId>com.github.uvera.helmet-spring-boot-starter</groupId>
            <artifactId>VARIANT (mvc|webflux)</artifactId>
            <version>VERSION</version>
        </dependency>
    </dependecies>
</project>
```

### Gradle

```kotlin
dependencies {
    implementation("com.github.uvera.helmet-spring-boot-starter:VARIANT (mvc|webflux):VERSION")
}
```

Enable following configuration properties

```yaml
spring-helmet:
  enable-cross-origin-embedder-policy: true
  enable-cross-origin-opener-policy: true
  enable-cross-origin-resource-policy: true
  enable-origin-agent-cluster: true
  enable-referrer-policy: true
  enable-strict-transport-security: true
  enable-do-not-sniff-mimetype: true
  enable-x-dns-prefetch-control: true
  enable-x-download-options: true
  enable-x-frame-options: true
  enable-x-permitted-cross-domain-policies: true
  remove-x-powered-by: true
  disable-x-xss-protection: true
  enable-content-security-policy: true
```

## How it works

Helmet works by conditionally autowiring various `WebFilter` (in Webflux) or `OncePerRequestFilter` (in MVC)
implementations to the filter chain.

You can tweak configuration by the following properties:

```yaml
spring-helmet:
  cross-origin-resource-policy: cross_origin
  cross-origin-opener-policy: same_origin
  referrer-policy: [ no_referrer ]
  strict-transport-security-max-age: 15552000
  strict-transport-security-include-sub-domains: true
  strict-transport-security-preload: false
  x-dns-prefetch-control: OFF
  x-frame-options: same_origin
  x-permitted-cross-domain-policies: none
  content-security-policy:
    use-default: true
    report-only: false
    # key value pairs where key: String, value: List<String>
    directives: { key: [ "value1", "value2" ] } 
```
