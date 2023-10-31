class GCN:
    '''
    GCN - Gene Co-expression Network with utility methods for
    statistical analysis.
    '''
    adj_M: list[list[bool]]
    n: int
    m: int

    '''
    Constructs a GCN from a correlation matrix.
    For all pair of genes, there is an edge between them iff
    their correlation is greater than or equal to t.
    '''
    def __init__(self, M: list[list[float]], t: float):
        n = len(M)

        self.n = n
        self.m = 0
        self.adj_M = [[0 for _ in range(n)] for _ in range(n)]

        if n <= 0:
            return
        
        for i in range(n):
            for j in range(len(M[i])):
                self.adj_M[i][j] = abs(M[i][j]) >= t and i != j
                if self.adj_M[i][j]:
                    self.m = self.m + 1

    def degrees(self):
        degrees = [0 for _ in range(self.n)]
        
        for i in range(len(self.adj_M)):
            degree = 0
            for j in range(len(self.adj_M[i])):
                if self.adj_M[i][j]:
                    degree = degree + 1
            degrees[i] = degree

        return degrees

    def degree_distribution(self):
        distr = [0 for _ in range(self.n)]

        degrees = self.degrees()

        for d in degrees:
            distr[d] = distr[d] + 1

        return distr
    
    def serialize(self, labels: list[str]) -> list[list[str]]:
        M = []

        for i in range(len(self.adj_M)):
            for j in range(i + 1, len(self.adj_M[i])):
                if self.adj_M[i][j]:
                    M.append([labels[i], labels[j]])

        return M