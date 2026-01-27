import torch
import torch.nn as nn


print(torch.cuda.is_available())
print(torch.cuda.get_device_name())
print(torch.cuda.current_device())

# input (XOR inputs)
X = torch.tensor([[0.0, 0.0], [0.0, 1.0], [1.0, 0.0], [1.0, 1.0]])
print(X)

# output (XOR outputs)
Y = torch.tensor([[0.0], [1.0], [1.0], [0.0]])
print(Y)


class SimpleNN(nn.Module):
    def __init__(self):
        super(SimpleNN, self).__init__()

        # Capa de entrada (2) → capa oculta (4)
        self.hidden = nn.Linear(2, 4)

        # Capa oculta (4) → capa de salida (1)
        self.output = nn.Linear(4, 1)

        # Función de activación
        self.sigmoid = nn.Sigmoid()

    def forward(self, x):
        x = self.sigmoid(self.hidden(x))
        x = self.sigmoid(self.output(x))
        return x


model = SimpleNN()
print(model)

# Loss Function BCELoss
criterion = nn.BCELoss()

# Optimizer (Gradient descent) Adam
optimizer = torch.optim.Adam(model.parameters(), lr=0.1)


# Traning Loop
epochs = 10000

for epoch in range(epochs):

    # Forward pass (Prediccion)
    outputs = model(X)

    # Calcular la perdida
    loss = criterion(outputs, Y)

    # Backpropagation
    optimizer.zero_grad()  # para limpiar los gradientes
    loss.backward()  # para calcular los gradientes
    optimizer.step()  # para actualizar los pesos

    if epoch % 50 == 0:
        print(f"Epoch: [{epoch}/{epochs}], Loss: {loss.item():.6f}")


# Probar el Model ya entrenado
with torch.no_grad():
    predictions = model(X)
    print("\nPredicciones:")
    print(predictions)
    print("\nPredicciones redondeadas:")
    print(torch.round(predictions))
