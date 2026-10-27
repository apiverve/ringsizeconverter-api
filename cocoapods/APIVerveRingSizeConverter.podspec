Pod::Spec.new do |s|
  s.name             = 'APIVerveRingSizeConverter'
  s.version          = '1.2.3'
  s.summary          = 'Ring Size Converter translates international ring sizes or millimeter diameters into US and UK standards, inside diameter, and...'
  s.description      = <<-'DESC'
Ring Size Converter translates international ring sizes or millimeter diameters into US and UK standards, inside diameter, and circumference. Paid plans add equivalent sizes for Europe, Japan, Switzerland, and Australia.

This iOS/macOS SDK provides a convenient way to access the Ring Size Converter from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/ringsizeconverter?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/ringsizeconverter-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveRingSizeConverter/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
