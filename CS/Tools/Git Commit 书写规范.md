### Git Commit 书写规范

#### 核心原则：清晰、简洁、完整、一致

一个好的 Commit 信息应该能够：
1.  **快速概览**：通过主题行快速了解本次提交的主要目的。
2.  **提供上下文**：如果需要，通过正文提供更详细的背景、原因和实现细节。
3.  **易于搜索**：方便通过关键词查找相关提交。
4.  **生成日志**：可以用于自动生成变更日志（Changelog）。

#### 结构：主题行 + 空行 + 正文 (可选)

一个标准的 Commit 信息通常包含三个部分：

```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
```

---

#### 1. 主题行 (Subject Line)

主题行是 Commit 信息的第一行，也是最重要的部分。它应该简洁明了地概括本次提交的内容。

*   **格式：`<type>(<scope>): <subject>`**
    *   **`<type>` (必需)**：表示本次提交的类型，说明了本次提交的意图。
        *   **`feat`**: 新功能 (feature)。
        *   **`fix`**: Bug 修复 (bug fix)。
        *   **`docs`**: 文档变更 (documentation)。
        *   **`style`**: 代码格式、样式调整，不影响代码逻辑 (e.g., 空格、分号、代码风格)。
        *   **`refactor`**: 代码重构，不引入新功能，不修复 bug (e.g., 改进代码结构、可读性)。
        *   **`test`**: 测试相关改动 (e.g., 添加测试、修改测试)。
        *   **`chore`**: 构建过程或辅助工具的变动，不涉及业务代码 (e.g., 依赖更新、构建脚本修改)。
        *   **`perf`**: 性能优化 (performance improvement)。
        *   **`ci`**: CI/CD 相关改动 (e.g., GitHub Actions, Jenkins)。
        *   **`build`**: 构建系统或外部依赖的改动 (e.g., webpack, npm)。
        *   **`revert`**: 回滚之前的提交。
    *   **`<scope>` (可选)**：表示本次提交影响的范围。可以是模块、组件、功能点等。用括号 `()` 包裹。
        *   例如：`feat(user): add user login` (用户模块)
        *   例如：`fix(auth): fix token expiration` (认证模块)
        *   如果影响范围很广或不明确，可以省略。
    *   **`<subject>` (必需)**：主题的简短描述。
        *   **使用命令式语气**：例如 "Add feature" 而不是 "Added feature" 或 "Adds feature"。
        *   **首字母大写**：例如 "Add" 而不是 "add"。
        *   **句末不加句号**。
        *   **长度限制**：建议在 **50-72 个字符**以内，以便在 `git log --oneline` 或 GitHub/GitLab 界面中完整显示。

*   **示例：**
    *   `feat(user): Add user registration endpoint`
    *   `fix(auth): Correct token validation logic`
    *   `docs: Update README with installation instructions`
    *   `refactor(product): Extract common product card component`
    *   `chore: Update dependencies to latest versions`

---

#### 2. 空行 (Blank Line)

主题行和正文之间必须有一个空行。这是 Git 的约定，没有空行，正文将不会被正确解析。

---

#### 3. 正文 (Body) (可选)

正文提供更详细的提交说明。当主题行不足以解释清楚本次提交时，正文就显得尤为重要。

*   **内容：**
    *   **解释“为什么”**：说明本次变更的动机、背景和解决的问题。
    *   **解释“如何”**：简要说明实现方式，特别是当实现比较复杂或有多种选择时。
    *   **解释“影响”**：说明本次变更可能带来的影响或副作用。
    *   **引用问题/任务**：关联到项目管理工具中的 Issue 或任务 ID (e.g., `Fixes #123`, `Closes JIRA-456`)。
    *   **列出重大变更**：如果引入了不兼容的 API 变更或重大行为改变，应在正文中明确指出，并以 `BREAKING CHANGE:` 开头。

*   **格式：**
    *   **每行长度限制**：建议每行不超过 **72 个字符**，以提高在终端中阅读的体验。
    *   **段落分隔**：使用空行分隔不同的段落。
    *   **使用列表**：如果需要列举多项内容，可以使用 `-` 或 `*` 作为列表项。

*   **示例：**

    ```
    feat(auth): Implement JWT-based authentication
    
    This commit introduces a new JWT-based authentication system to
    replace the previous session-based authentication.
    
    Motivation:
    - Improve scalability by making the system stateless.
    - Enhance security by using signed tokens.
    - Prepare for mobile app integration.
    
    Implementation details:
    - Uses `jsonwebtoken` library for token generation and verification.
    - Adds `/api/auth/login` and `/api/auth/register` endpoints.
    - Middleware for protecting routes is added to `src/middleware/auth.js`.
    
    Closes #42
    ```

---

#### 4. 脚注 (Footer) (可选)

脚注通常用于引用 Issue 或 Pull Request，或者声明 `BREAKING CHANGE`。

*   **格式：**
    *   `Fixes #<issue-number>`
    *   `Closes #<issue-number>`
    *   `Refs #<issue-number>`
    *   `BREAKING CHANGE: <description>`

*   **示例：**

    ```
    feat(api): Add new user profile endpoint
    
    This commit adds a new endpoint `/api/v1/users/{id}/profile` to
    retrieve detailed user profile information.
    
    BREAKING CHANGE: The old `/api/v1/users/{id}` endpoint no longer
    returns full profile data. Clients should update to use the new
    `/api/v1/users/{id}/profile` endpoint for complete profiles.
    
    Closes #101, #102
    ```

---

### 最佳实践

1.  **原子性提交 (Atomic Commits)**：每次提交只做一件事。避免将多个不相关的修改混在一个提交中。这使得回滚、审查和理解历史变得更容易。
2.  **提交前自查**：在提交之前，使用 `git diff --cached` 或 `git status` 检查你暂存的修改，确保它们与你的提交信息相符。
3.  **使用 Git Hooks 或工具**：可以使用 `commitlint` 配合 `husky` 等工具来自动化检查 Commit 信息是否符合规范。
4.  **保持语言一致**：如果团队约定使用英文，则所有 Commit 信息都应使用英文。
5.  **避免提交不完整或损坏的代码**：每次提交都应该是可编译、可运行且通过测试的。
6.  **善用 `git rebase -i`**：在推送到远程共享分支之前，可以使用交互式 rebase 来整理、合并或修改本地的 Commit 历史，使其更清晰。

遵循这些规范，将大大提高项目的可维护性和团队的协作效率。