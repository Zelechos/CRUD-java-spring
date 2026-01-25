import torch
import torch.nn as nn
import torch.optim as optim

print(torch.__version__)
print(nn.modules.__all__)
print(optim.__all__)
print(nn.Conv1d(1, 1, 1))

print(torch.cuda.is_available())
print(torch.cuda.get_device_name(0))
print(torch.cuda.get_device_properties(0))
print(torch.cuda.current_device())
