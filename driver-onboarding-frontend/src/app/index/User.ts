import { Driver } from "./Driver";
import { Rider } from "./Rider";
import { UserType } from "./UserType";

export interface User {
    id?: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    profilePicture: string;
    active: boolean;
    userType: UserType;
    driver?: Driver;
    rider?: Rider
}