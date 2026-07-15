declare module '@apiverve/ringsizeconverter' {
  export interface ringsizeconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface ringsizeconverterResponse {
    status: string;
    error: string | null;
    data: RingSizeConverterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface RingSizeConverterData {
      inputDiameterMm: number | null;
      circumferenceMm: number | null;
      conversions:     Conversions;
      note:            null | string;
  }
  
  interface Conversions {
      diameterMm:      number | null;
      circumferenceMm: number | null;
      us:              number | null;
      uk:              null | string;
      eu:              number | null;
      jp:              number | null;
      ch:              number | null;
      au:              null | string;
  }

  export default class ringsizeconverterWrapper {
    constructor(options: ringsizeconverterOptions);

    execute(callback: (error: any, data: ringsizeconverterResponse | null) => void): Promise<ringsizeconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: ringsizeconverterResponse | null) => void): Promise<ringsizeconverterResponse>;
    execute(query?: Record<string, any>): Promise<ringsizeconverterResponse>;
  }
}
