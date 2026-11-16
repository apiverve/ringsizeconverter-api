# Ring Size Converter API - Dart/Flutter Client

Ring Size Converter translates international ring sizes or millimeter diameters into US and UK standards, inside diameter, and circumference. Paid plans add equivalent sizes for Europe, Japan, Switzerland, and Australia.

[![pub package](https://img.shields.io/pub/v/apiverve_ringsizeconverter.svg)](https://pub.dev/packages/apiverve_ringsizeconverter)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Ring Size Converter API](https://apiverve.com/marketplace/ringsizeconverter?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_ringsizeconverter: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_ringsizeconverter/apiverve_ringsizeconverter.dart';

void main() async {
  final client = RingsizeconverterClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'size': '7',
      'from': 'us'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Ring Size Converter API](https://apiverve.com/marketplace/ringsizeconverter?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/ringsizeconverter](https://docs.apiverve.com/ref/ringsizeconverter?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
