namespace DiscountApplier
{
    public interface INotifier
    {
        void Notify(User user, string message);
    }
}
