import { User } from "./User";

export interface Request {
    id:string;
    user: User | null,
    departureLatitude: number,
    departureLongitude: number,
    arrivalLatitude: number,
    arrivalLongitude: number
}