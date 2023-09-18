import { User } from "./User"

export interface Request {
    id: string,
    user: User,
    departureLatitude: number,
    departureLongitude: number,
    arrivalLatitude: number,
    arrivalLongitude: number
}