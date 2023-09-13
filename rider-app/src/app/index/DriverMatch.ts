import { DriverLocation } from "./DriverLocation";
import { Request } from "./Request";

export interface DriverMatch {
    stage: DriverMatchStage,
    request: Request,
    driverLocation: DriverLocation
}

export enum DriverMatchStage {
    MATCH,
    ACCEPT,
    REJECT,
    DRIVER_NO_FOUND
}