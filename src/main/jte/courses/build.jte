@template.layout.page(
    title = "Добавление курса",
    content = @`
        <h1>Добавить новый курс</h1>

        <form action="/courses" method="post">
            <div style="margin-bottom: 15px;">
                <label>
                    Название курса:
                    <br/>
                    <input type="text" name="name" required style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Описание:
                    <br/>
                    <textarea name="description" rows="5" required style="width: 100%; padding: 8px; margin-top: 5px;"></textarea>
                </label>
            </div>

            <button type="submit" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px;">
                Создать курс
            </button>
            <a href="/courses" style="margin-left: 10px;">Отмена</a>
        </form>
    `
)