# Ring Size Converter API - Ruby Gem

Ring Size Converter translates international ring sizes or millimeter diameters into US and UK standards, inside diameter, and circumference. Paid plans add equivalent sizes for Europe, Japan, Switzerland, and Australia.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_ringsizeconverter'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_ringsizeconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_ringsizeconverter'

# Initialize the client
client = APIVerve::Ringsizeconverter::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  size: "7",
  from: "us"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ size: "7", from: "us" })
  puts response["data"]
rescue APIVerve::Ringsizeconverter::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Ringsizeconverter::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Ringsizeconverter::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/ringsizeconverter?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/ringsizeconverter?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/ringsizeconverter?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
