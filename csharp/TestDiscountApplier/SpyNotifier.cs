using DiscountApplier;

namespace TestDiscountApplier;

public class SpyNotifier : INotifier
{
    public void Notify(User user, string message)
    {
        Notified.Add(user.Name);
    }

    public List<string> Notified { get; } = new();
}