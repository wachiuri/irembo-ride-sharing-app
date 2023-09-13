import { User } from "./User";

export interface Request {
    user: User | null,
    departureLatitude: number,
    departureLongitude: number,
    arrivalLatitude: number,
    arrivalLongitude: number
}