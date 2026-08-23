# Copilot instructions

- This is an IntelliJ IDEA + Maven + Selenium + TestNG QA automation training repository for a Danaher/Cepheid workshop.
- The application under test is a small local static HTML portal in `app/`. Tests should open pages using local `file:///` URLs or the provided `PortalUrl` helper.
- Follow the Page Object Model: locators and browser actions belong in `pages/`, not in test classes.
- Use explicit waits (`WebDriverWait`) instead of `Thread.sleep()`.
- Never hardcode credentials or environment URLs inside test methods; use `TestConfig`/`TestData` instead.
- Keep tests independent â€” no test should depend on another test's execution order or shared mutable state.
- Validate every change by running `mvn test` before considering the task complete.
