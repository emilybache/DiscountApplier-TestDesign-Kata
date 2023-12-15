namespace DiscountApplier;

public readonly struct User
{
    public User(string name, string email)
    {
        Name = name;
        Email = email;
    }

    public string Name { get; init; }
    public string Email { get; init; }
}