/// Response models for the Ring Size Converter API.

/// API Response wrapper.
class RingsizeconverterResponse {
  final String status;
  final dynamic error;
  final RingsizeconverterData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  RingsizeconverterResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory RingsizeconverterResponse.fromJson(Map<String, dynamic> json) => RingsizeconverterResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? RingsizeconverterData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Ring Size Converter API.

class RingsizeconverterData {
  num? inputDiameterMm;
  num? circumferenceMm;
  RingsizeconverterDataConversions? conversions;
  String? note;

  RingsizeconverterData({
    this.inputDiameterMm,
    this.circumferenceMm,
    this.conversions,
    this.note,
  });

  factory RingsizeconverterData.fromJson(Map<String, dynamic> json) => RingsizeconverterData(
      inputDiameterMm: json['input_diameter_mm'],
      circumferenceMm: json['circumference_mm'],
      conversions: json['conversions'] != null ? RingsizeconverterDataConversions.fromJson(json['conversions']) : null,
      note: json['note'],
    );
}

class RingsizeconverterDataConversions {
  num? diameterMm;
  num? circumferenceMm;
  num? us;
  String? uk;
  num? eu;
  num? jp;
  num? ch;
  String? au;

  RingsizeconverterDataConversions({
    this.diameterMm,
    this.circumferenceMm,
    this.us,
    this.uk,
    this.eu,
    this.jp,
    this.ch,
    this.au,
  });

  factory RingsizeconverterDataConversions.fromJson(Map<String, dynamic> json) => RingsizeconverterDataConversions(
      diameterMm: json['diameter_mm'],
      circumferenceMm: json['circumference_mm'],
      us: json['us'],
      uk: json['uk'],
      eu: json['eu'],
      jp: json['jp'],
      ch: json['ch'],
      au: json['au'],
    );
}

class RingsizeconverterRequest {
  String size;
  String from;

  RingsizeconverterRequest({
    required this.size,
    required this.from,
  });

  Map<String, dynamic> toJson() => {
      'size': size,
      'from': from,
    };
}
