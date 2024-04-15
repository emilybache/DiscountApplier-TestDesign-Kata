export interface Notifier {
    notify(user: string, message: string): void;
}