# Nome da tarefa padrão
all: send-message-order

# Variáveis para tornar o Makefile mais flexível
URL := http://localhost:15672/api/exchanges/%2F/amq.default/publish
USER := guest
PASSWORD := guest
CONTENT_TYPE := application/json
ROUTING_KEY := btg-pactual-order-created
PAYLOAD := { "properties": {"delivery_mode": 1}, "routing_key": "btg-pactual-order-created", "payload": "{\"codigoPedido\": 1001,\"codigoCliente\":1,\"itens\":[{\"produto\": \"lápis\",\"quantidade\": 100,\"preco\": 1.10 },{\"produto\": \"caderno\", \"quantidade\": 10,\"preco\": 1.00}]}", "payload_encoding": "string" }

# Tarefa principal
send-message-order:
	curl -i -u guest:guest -H "content-type:$(CONTENT_TYPE)" \
	-XPOST \
    -d'$(PAYLOAD)' \
    $(URL)

# Limpar (se necessário)
clean:
	@echo "Clean nothing to do."

.PHONY: all send-message-order clean