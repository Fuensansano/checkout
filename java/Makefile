help:
	@echo ""
	@echo "usage: make COMMAND"
	@echo ""
	@echo "Commands:"
	@echo "  install/pre-commit         💻 Installs all pre-commit hook to format your code before commit"
	@echo "  run/pre-commit             🚀 Starts the pre-commit hook git the changes added to the git index"

install/pre-commit:
	@echo "Trying to copy pre-commit into .git/hooks folder"
	@cp ./pre-commit ../.git/hooks
	@chmod +x ../.git/hooks/pre-commit
	@ls -la  ../.git/hooks/ | grep pre-commit

run/pre-commit:
	bash ./pre-commit
