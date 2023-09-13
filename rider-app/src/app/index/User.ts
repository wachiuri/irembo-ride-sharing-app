import { Driver } from "./Driver";
import { Rider } from "./Rider";
import { UserType } from "./UserType";

export interface User {
    id: number | null;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    phoneNumber: string;
    profilePicture: string;
    active: boolean;
    userType: UserType;
    driver: Driver | null;
    rider: Rider | null
}