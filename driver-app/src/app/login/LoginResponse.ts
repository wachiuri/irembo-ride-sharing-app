import { User } from "../index/User";

export interface LoginResponse {
    user:User;
    token: string,
    status: number
}