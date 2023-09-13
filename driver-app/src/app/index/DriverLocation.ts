import { User } from "./User";

export interface DriverLocation {
    user: User | null;
    lat: number;
    lng: number;
    cellAddress: string;
}