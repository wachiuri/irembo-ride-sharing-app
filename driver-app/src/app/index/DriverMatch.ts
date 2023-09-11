import { DriverLocation } from "./DriverLocation";
import { Request } from "./Request";

export interface DriverMatch {
    request: Request,
    driverLocation: DriverLocation
}