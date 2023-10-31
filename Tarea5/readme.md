# Gene Coexpression Network

**Gene Coexpression Networks** - _GCN_ capture gene expression data that ease the study of an organism genome.

A _GCN_ $G$ has vertices that represent a gene, and there is an edge between any pair of vertices $u$ and $v$ if those genes are significantly correlated.

These networks are usually constructed from gene expression data in the form of matrices. More precisely, a gene expression matrix $M$ has $m$ rows that correspond to the studied genes, and $n$ columns that correspond to a sample. The value in each cell $(i, j)$ quantifies the expression level of a gene $G_i$ in the sample $S_j$.

Two samples may be from different organisms, or the same organism under different constraints. For instance, we may carry out an experiment where we wish to understand the expression level of genes for a healthy and non-healthy subject in order to determine what genes are active for a particular illness. In this case we could sample 50 healthy and 50 non-healthy organisms.

This software was implemented and tested with [Python 3.9](https://www.python.org/downloads/release/python-390/).

## Dataset

The dataset folder contains the following resources.

- `LiverFemale3600.csv` A microarray result for a gene expression experiment on female mouse liver cells.

## How to run this program?

- Check if Python 3.9 is correctly installed.

```sh
python --version
```

- We recommend creating a virtual environment named `env` for the project.

On Linux/MacOS, run:

```sh
python3 -m venv env
```

On Windows, run:

```sh
python -m venv env
```

- Activate the virtual environment.

On Linux/MacOS, run:

```sh
source env/bin/activate
```

On Windows, run:

```sh
.\env\Scripts\activate
```

- Install required packages

```sh
pip install -r requirements.txt
```