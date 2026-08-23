# QA Test Refactoring Lab (Selenium + TestNG)

## Objective
Learn to use GitHub Copilot inside **IntelliJ IDEA** to complete a realistic Danaher/Cepheid engineering task.

## Duration
40-45 minutes

## Prerequisites
- IntelliJ IDEA (Community or Ultimate)
- JDK 17+
- Maven 3.9+
- GitHub Copilot and GitHub Copilot Chat plugins enabled in IntelliJ
- Git
- Google Chrome installed (Selenium Manager auto-downloads the matching ChromeDriver)

## IntelliJ Setup
1. Open IntelliJ IDEA and choose **File > Open**, then select this repository folder.
2. Trust the project when prompted and let IntelliJ auto-import the Maven project.
3. Confirm the Project SDK is Java 17 in **File > Project Structure > Project**.
4. Open the **Maven** tool window (right sidebar) to run `test`/`verify` goals.
5. Open **GitHub Copilot Chat** from the right tool bar, keep the relevant file active so Copilot has context.

## Scenario
The CepheidDx portal automation suite grew quickly and now has duplicated login steps, hardcoded waits, and weak assertions spread across `PortalWorkflowTest`.

## Starting Point
`PortalWorkflowTest` duplicates the login flow in every test method, uses `Thread.sleep()` for timing, has broad empty catch blocks, and only prints to stdout instead of asserting real conditions.

## Hands-on Tasks
1. Ask Copilot to identify every automation code smell in `PortalWorkflowTest` (duplication, hardcoded waits, weak assertions, exception handling).
2. Extract the duplicated login steps into a small reusable helper method or class.
3. Replace every `Thread.sleep()` with an explicit `WebDriverWait` condition on the relevant element.
4. Replace the `println`-based checks with real TestNG assertions (`assertTrue`/`assertEquals`).
5. Replace the empty `catch (Exception e)` blocks with either a narrower exception type or removing the try/catch where it is unnecessary.
6. Run the refactored suite and confirm both tests still pass with the same intended behavior.

## Validation
Run from the IntelliJ **Terminal** tab (Alt+F12) or the Maven tool window:

```bash
mvn test
```

## Expected Result
Login logic is shared (not duplicated), there are no `Thread.sleep()` calls, assertions are meaningful, and tests remain green.

## Troubleshooting
- If explicit waits time out, confirm you are waiting for `ExpectedConditions.visibilityOfElementLocated` on an id that exists on the target page.
- If refactoring breaks a test, refactor one method at a time and re-run after each change.

## Optional Challenge
Introduce a small `LoginSteps` helper class used by both tests, and add a third test for the dashboard navigation flow using the same helper.

## Copilot Customization Guide

**Already provided:** `.github/instructions/copilot-instructions.md`.

**New prompt file:** `.github/prompts/test-refactor-prompt.md`

```
Role: Refactor PortalWorkflowTest
Task: remove duplication, replace sleep with explicit waits, add real assertions
Constraints: keep test intent identical; no new dependencies
Output: refactored class only
```

**Step-by-step: create these yourself (not provided)**
1. Custom agent â€” create `.github/agents/qa-refactor-agent.agent.md`:
   - Persona: a persona that removes automation duplication and replaces hardcoded waits with explicit waits.
   - Before writing the file, design its fixed step sequence and any constraints on paper first.
   - Test it on one small, low-risk task before relying on it for the full lab task.
2. Skill â€” create `.github/skills/test-refactor-checklist/SKILL.md`:
   - Describe when it applies, the concrete conventions for cleaning up Selenium/TestNG automation without changing behavior, and include one short example.
   - Reference the skill explicitly in a Copilot Chat prompt and confirm the output follows its conventions.
3. Root `AGENTS.md` (optional) â€” summarize build/test commands and where the `.github/` customization files live, for cross-tool agent compatibility (Copilot CLI and other agentic tools read this file).

**Enterprise tip:** Enterprise Copilot usage favors small, structured, reusable prompts over long free-form ones. State `Role / Task / Constraints / Output` in under ~5 lines - this keeps token usage low and responses focused, which matters when Copilot is used constantly across a team.
