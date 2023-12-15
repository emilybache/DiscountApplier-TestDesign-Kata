using DiscountApplier;
using Assert = NUnit.Framework.Assert;

namespace TestDiscountApplier;

[TestFixture]
public class DiscountApplierNUnitTest
{
    [Test]
    public void TestApplyV1()
    {
        var notifier = new SpyNotifier();
        var user1 = new User("user1", "user1@example.com");
        var discountApplier = new DiscountApplier.DiscountApplier(notifier);
        
        discountApplier.ApplyV1(20, new List<User>() {user1});
        
        Assert.Contains(user1.Name, notifier.Notified);
    }

    [Test]
    public void TestApplyV2()
    {
        var notifier = new SpyNotifier();
        var user1 = new User("user1", "user1@example.com");
        var user2 = new User("user2", "user2@example.com");
        var discountApplier = new DiscountApplier.DiscountApplier(notifier);
        
        discountApplier.ApplyV2(20, new List<User>() {user1, user2});
        
        Assert.Contains(user1.Name, notifier.Notified);
        Assert.Contains(user2.Name, notifier.Notified);
    }
}