import { User } from "./User";

export interface DriverLocation {
    user: User
    lat: number;
    lng: number;
    cellAddress: string;
}