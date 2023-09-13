import { User } from "./User"

export interface Request {
    user: User,
    departureLatitude: number,
    departureLongitude: number,
    arrivalLatitude: number,
    arrivalLongitude: number
}