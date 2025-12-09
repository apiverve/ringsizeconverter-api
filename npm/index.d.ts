declare module '@apiverve/ringsizeconverter' {
  export interface ringsizeconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface ringsizeconverterResponse {
    status: string;
    error: string | null;
    data: RingSizeConverterData;
    code?: number;
  }


  interface RingSizeConverterData {
      inputDiameterMm: number;
      circumferenceMm: number;
      conversions:     Conversions;
      note:            string;
  }
  
  interface Conversions {
      diameterMm:      number;
      circumferenceMm: number;
      us:              number;
      uk:              string;
      eu:              number;
      jp:              number;
      ch:              number;
      au:              string;
  }

  export default class ringsizeconverterWrapper {
    constructor(options: ringsizeconverterOptions);

    execute(callback: (error: any, data: ringsizeconverterResponse | null) => void): Promise<ringsizeconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: ringsizeconverterResponse | null) => void): Promise<ringsizeconverterResponse>;
    execute(query?: Record<string, any>): Promise<ringsizeconverterResponse>;
  }
}
