@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    title = "Пользователи",
    content = @`
        <h1>Список пользователей</h1>

        <p>
            <a href="/users/build" style="background-color: #4CAF50; color: white; padding: 10px 15px; text-decoration: none; border-radius: 5px;">
                + Добавить пользователя
            </a>
        </p>

        @if(page.getUsers().isEmpty())
            <p>Пока нет пользователей. Добавьте первого!</p>
        @else
            <table style="width: 100%; border-collapse: collapse;">
                <thead>
                    <tr style="background-color: #f2f2f2;">
                        <th style="padding: 10px; text-align: left;">ID</th>
                        <th style="padding: 10px; text-align: left;">Имя</th>
                        <th style="padding: 10px; text-align: left;">Email</th>
                    </tr>
                </thead>
                <tbody>
                    @for(var user : page.getUsers())
                        <tr style="border-bottom: 1px solid #ddd;">
                            <td style="padding: 10px;">${user.getId()}</td>
                            <td style="padding: 10px;">${user.getName()}</td>
                            <td style="padding: 10px;">${user.getEmail()}</td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    `
)