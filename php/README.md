# Ring Size Converter API - PHP Package

Ring Size Converter translates international ring sizes or millimeter diameters into US and UK standards, inside diameter, and circumference. Paid plans add equivalent sizes for Europe, Japan, Switzerland, and Australia.

## Installation

Install via Composer:

```bash
composer require apiverve/ringsizeconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Ringsizeconverter\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'size' => '7',
    'from' => 'us'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Ringsizeconverter\Client;
use APIVerve\Ringsizeconverter\Exceptions\APIException;
use APIVerve\Ringsizeconverter\Exceptions\ValidationException;

try {
    $response = $client->execute(['size' => '7', 'from' => 'us']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "input_diameter_mm": 17.3,
    "circumference_mm": 54.3,
    "conversions": {
      "diameter_mm": 17.3,
      "circumference_mm": 54.3,
      "us": 7,
      "uk": "N",
      "eu": 52,
      "jp": 17,
      "ch": -22,
      "au": "N"
    },
    "note": "Sizes are approximate. For accurate sizing, visit a jeweler."
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/ringsizeconverter?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/ringsizeconverter?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/ringsizeconverter?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
