import torch
import torch.nn as nn

# input (XOR inputs)
X = torch.tensor([[0.0, 0.0], [0.0, 1.0], [1.0, 0.0], [1.0, 1.0]])
print(X)

# output (XOR outputs)
Y = torch.tensor([[0.0], [1.0], [1.0], [0.0]])
print(Y)


class SimpleNN(nn.Module):
    def __init__(self):
        super(SimpleNN, self).__init__()
        # Capa Lineal tambien conocida como capa densa o fully connected
        # capa de entrada -> capa oculta
        self.hidden = nn.Linear(2, 4)
        # capa oculta -> capa de salida
        self.output = nn.Linear(4, 1)
        # funcion de activacion Sigmoide
        self.sigmoid = nn.Sigmoid()

    # Funcion de entrenamiento del modelo
    def forward(self, x):
        x = self.sigmoid(self.hidden(x))
        x = self.sigmoid(self.output(x))
        return x
