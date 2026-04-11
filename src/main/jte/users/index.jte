@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    title = "Пользователи",
    content = @`
        <h1>Список пользователей</h1>

        <p><a href="${NamedRoutes.buildUserPath()}">+ Добавить пользователя</a></p>

        @if(page.getUsers().isEmpty())
            <p>Пока нет пользователей. Добавьте первого!</p>
        @else
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Имя</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    @for(var user : page.getUsers())
                        <tr>
                            <td>${user.getId()}</td>
                            <td>${user.getName()}</td>
                            <td>${user.getEmail()}</td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    `
)
