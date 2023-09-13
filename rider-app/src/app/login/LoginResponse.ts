import { User } from "../index/User";

export interface LoginResponse {
    token: string,
    status: number,
    user: User | null
}