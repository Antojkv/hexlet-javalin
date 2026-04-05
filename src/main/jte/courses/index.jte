@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список курсов - Хекслет</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            border-bottom: 3px solid #4CAF50;
            padding-bottom: 10px;
        }
        .course-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }
        .course-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .course-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }
        .course-title {
            color: #4CAF50;
            margin-top: 0;
        }
        .course-title a {
            color: #4CAF50;
            text-decoration: none;
        }
        .course-title a:hover {
            text-decoration: underline;
        }
        .course-description {
            color: #666;
            line-height: 1.5;
        }
        .empty-message {
            text-align: center;
            color: #999;
            padding: 50px;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>${page.getHeader()}</h1>

        @if(page.getCourses().isEmpty())
            <div class="empty-message">
                <p>📚 Пока не добавлено ни одного курса</p>
            </div>
        @else
            <div class="course-list">
                @for(var course : page.getCourses())
                    <div class="course-card">
                        <h2 class="course-title">
                            <a href="/courses/${course.getId()}">${course.getName()}</a>
                        </h2>
                        <p class="course-description">${course.getDescription()}</p>
                        <small>ID курса: ${course.getId()}</small>
                    </div>
                @endfor
            </div>
        @endif
    </div>
</body>
</html>