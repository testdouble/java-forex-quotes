# java-forex-quotes

java-forex-quotes is a Java library for fetching realtime forex quotes. It is the Java counterpart of [ruby-forex-quotes](https://github.com/testdouble/ruby-forex-quotes).

# Table of Contents

- [Installation](#installation)
- [Usage](#usage)
  - [Instantiate the client](#instantiate-the-client)
  - [Get the rate to convert from one currency to another](#get-the-rate-to-convert-from-one-currency-to-another)
  - [Convert a specific amount](#convert-a-specific-amount-from-cents-to-yen)
- [License / Terms](#license-and-terms)

## Installation

The library is published through [JitPack](https://jitpack.io). Requires Java 21.

Gradle:

```groovy
repositories {
	mavenCentral()
	maven { url = 'https://jitpack.io' }
}

dependencies {
	implementation 'com.github.testdouble:java-forex-quotes:main-SNAPSHOT'
}
```

Maven:

```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
	<groupId>com.github.testdouble</groupId>
	<artifactId>java-forex-quotes</artifactId>
	<version>main-SNAPSHOT</version>
</dependency>
```

## Usage

### Instantiate the client

```java
import com.testdouble.forexquotes.ForexDataClient;

ForexDataClient client = new ForexDataClient("YOUR_API_KEY");
```

### Get the rate to convert from one currency to another. Note this expects cents not dollars

```java
client.getRate("USD", "JPY");
// {JPY=1049.31}
```

### Convert a specific amount from cents to yen.

```java
client.convert("USD", "JPY", 100);
// {JPY=14900.45}
```

Both methods throw `ExchangeServiceDownException` when the exchange service cannot be reached.

## License and Terms

This library is provided without warranty under the MIT license.
